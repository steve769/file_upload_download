package info.stephenderrick.filesuploadownload.service;


import info.stephenderrick.filesuploadownload.entity.Attachment;
import info.stephenderrick.filesuploadownload.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService{

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(fileName);
        try{
            if(fileName.contains("..")){
                throw new Exception("Please Check File Path");
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());

            return attachmentRepository.save(attachment);
        } catch (Exception e){
                throw new Exception("Something went wrong");
        }

    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId).orElseThrow(() -> new Exception("File Not Found"));
    }
}
