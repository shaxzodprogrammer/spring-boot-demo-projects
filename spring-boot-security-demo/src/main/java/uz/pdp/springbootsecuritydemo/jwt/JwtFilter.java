package uz.pdp.springbootsecuritydemo.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.pdp.springbootsecuritydemo.service.AuthService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //O'ZIMIZ YOZGAN METHOD. MAQSAD USER(USERDETAILS) NI OLISH
        UserDetails userDetails = getUserDetails(httpServletRequest);
        //BEARE TOKEN YOKI BASIC TOKEN ORQALI TEKSHIRILIB OLINGAN USER
        if (userDetails != null) {
            if (userDetails.isEnabled()
                    && userDetails.isAccountNonExpired()
                    && userDetails.isAccountNonLocked()
                    && userDetails.isCredentialsNonExpired()) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public UserDetails getUserDetails(HttpServletRequest httpServletRequest) {
        try {
            //REQUESTNI HEADER DAN "AUTHORIZATION" KALIT SO'Z ORQALI TOKENNI OLISH
            String tokenClient = httpServletRequest.getHeader("Authorization");
            //TOKENNI NULL GA TEKSHIRISH
            if (tokenClient != null) {
                //TOKENNI BEARER EKANLIGINI TEKSHIRISH
                if (tokenClient.startsWith("Bearer ")) {
                    //TOKENNI 7 INDEX DAN BOSHLAB KESIB OLISH
                    tokenClient = tokenClient.substring(7);
                    //TOKENNI VALID LIGINI TEKSHIRISH
                    if (jwtTokenProvider.validateToken(tokenClient)) {
                        //USERID ni oldik tokendan
                        String userIdFromToken = jwtTokenProvider.getUserIdFromToken(tokenClient);
                        return authService.loadUserByUserId(userIdFromToken);
                    }
                }
            }
        } catch (Exception ignored) {
        }
        return null;
    }
}
