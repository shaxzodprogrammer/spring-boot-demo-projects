package uz.pdp.springbootfileuploaddownloaddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootfileuploaddownloaddemo.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

}
