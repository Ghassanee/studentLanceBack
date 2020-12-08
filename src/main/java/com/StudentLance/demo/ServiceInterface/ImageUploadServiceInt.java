package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.ImageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity.BodyBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public interface ImageUploadServiceInt {

    ImageModel uplaodImage(MultipartFile file) throws IOException;

    ImageModel getImage(String imageName) throws IOException;


}
