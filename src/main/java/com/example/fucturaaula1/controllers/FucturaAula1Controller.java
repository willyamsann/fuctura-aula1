package com.example.fucturaaula1.controllers;

import com.example.fucturaaula1.models.Pessoa; // importação da Model

import org.springframework.http.ResponseEntity; // Resposta Http
import org.springframework.web.bind.annotation.GetMapping; // Anotação para request GET
import org.springframework.web.bind.annotation.RequestMapping; // Anotação para request mapeamento
import org.springframework.web.bind.annotation.RestController; // Anotação para Controller do Tipo Rest
import org.springframework.web.bind.annotation.PostMapping; // Anotação para request tipo POST Ex: Criando objeto
import org.springframework.web.bind.annotation.PathVariable; // Anotação para path de urls
import org.springframework.web.bind.annotation.RequestBody; // Anotação para enviar o objeto pelo Body

@RestController
@RequestMapping("api/fuctura")
public class FucturaAula1Controller {
  

  //http://localhost:8080/api/fuctura/helloword
  @GetMapping("/helloword")
  public ResponseEntity<String> getHelloWord(){
    return ResponseEntity.ok("Hello Word");
  }

  //Vamos testa BadRequest
  @GetMapping("/pessoa/{id}")
  public ResponseEntity<String> getPessoa(@PathVariable(value = "id") long id){

    if(id == 1){
      return ResponseEntity.ok("Pessoa Encontrada");
    }else{
      return ResponseEntity.badRequest().body("Pessoa não encontrada");
    }
  }

  @PostMapping("/pessoa")
  public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa){
    return ResponseEntity.ok().body(pessoa);
  }
}
