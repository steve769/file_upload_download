package info.stephenderrick.filesuploadownload.repository;

import info.stephenderrick.filesuploadownload.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
