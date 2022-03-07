package com.kosign.luna.model.greeting;

public class Greeting {
    private String content;
    private String name;

    public Greeting() {
    }
    


  public Greeting(String content, String name) {
    this.content = content;
    this.name = name;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
 
}
