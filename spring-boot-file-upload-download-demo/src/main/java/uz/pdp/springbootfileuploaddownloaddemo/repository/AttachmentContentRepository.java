package uz.pdp.springbootfileuploaddownloaddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.springbootfileuploaddownloaddemo.entity.Attachment;
import uz.pdp.springbootfileuploaddownloaddemo.entity.AttachmentContent;

import java.util.Optional;
import java.util.UUID;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {
    AttachmentContent findByAttachmentId(UUID attachment_id);
}
