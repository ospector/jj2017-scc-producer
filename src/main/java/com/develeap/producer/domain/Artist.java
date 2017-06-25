package com.develeap.producer.domain;

import lombok.Data;

@Data
public class Artist {
  private long id;
  private String name;
  private int yearOfBirth;
  private int yearOfDeath;
}
