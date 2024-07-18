package com.nuguna.freview.global.util;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

public class ShaUtil {
  public static String sha256Encoding(String purePw) {
    return Hashing.sha256().hashString(purePw, StandardCharsets.UTF_8).toString();
  }
}
