// package com.kosign.luna.rest_controller;

// import com.kosign.luna.model.greeting.Greeting;
// import com.kosign.luna.model.greeting.Message;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.util.HtmlUtils;

// @CrossOrigin(origins = "*", allowedHeaders = "*")
// @RestController
// @RequestMapping(path = "/rest")
// public class MessageController {
//     @Autowired
//     private SimpMessagingTemplate template;

//   @GetMapping("/lunaChart")
//   public void sendMessage(){
//       template.convertAndSend("/topic/greetings", new Greeting("Khaw", "Hello to message real time"));
//   }

//   @GetMapping(path="/{name}", produces = "application/json")
//   public String getGreeting(@PathVariable("name") String name)
//   {
//       return "{\"greeting\" : \"Hello, " + name + "!\"}";
//   }
  
//   @MessageMapping("/hello")
//   @SendTo("/topic/greetings")
//   public Greeting greeting(Message message) throws Exception {
//       return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!", " hello");
//   }


  
// }
