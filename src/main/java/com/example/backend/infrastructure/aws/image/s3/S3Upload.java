package com.example.backend.infrastructure.aws.image.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.backend.domain.user.domain.User;
import com.example.backend.domain.user.enums.Role;
import com.example.backend.domain.user.facade.UserFacade;
import com.example.backend.domain.user.domain.repository.UserRepository;
import com.example.backend.global.error.ErrorCode;
import com.example.backend.global.error.exeception.CustomException;
import com.example.backend.infrastructure.aws.image.DefaultImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Upload {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final UserFacade userFacade;
    private final AmazonS3Client amazonS3Client;
    private final UserRepository userRepository;

    public String uploadImage(MultipartFile multipartFile){
        return upload(multipartFile);
    }

    public void delUser(User user){
        if(!Objects.equals(user.getProfile(), DefaultImage.USER_PROFILE_IMAGE)){
            amazonS3Client.deleteObject(bucket,user.getProfile());
        }

    }

    private String getImageUrl(String s3FileName){
        return amazonS3Client.getUrl(bucket, s3FileName).toString();
    }

    public String upload(MultipartFile multipartFile){
        String s3FileName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        ObjectMetadata objMeta = new ObjectMetadata();
        try {
            objMeta.setContentLength(multipartFile.getInputStream().available());
            amazonS3Client.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);
        } catch (IOException e) {
            throw new CustomException(ErrorCode.IMAGE_NOT_FOUND);
        }

        return getImageUrl(s3FileName);
    }
}