package com.nuguna.freview.global;

import static com.nuguna.freview.global.FileUtil.getFullPath;

import com.nuguna.freview.customer.mapper.UserFileMapper;
import java.net.MalformedURLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FileController {

  private final UserFileMapper userFileMapper;

  @Autowired
  public FileController(UserFileMapper userFileMapper) {
    this.userFileMapper = userFileMapper;
  }

  @RequestMapping("/user/{userSeq}/profile")
  public Resource downloadImage(@PathVariable Long userSeq) throws MalformedURLException {
    String filename = userFileMapper.getFilename(userSeq);
    return new UrlResource("file:" + getFullPath(filename));
  }

}
