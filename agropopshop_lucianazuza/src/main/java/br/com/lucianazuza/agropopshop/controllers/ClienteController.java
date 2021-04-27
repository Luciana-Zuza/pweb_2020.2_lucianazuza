package br.com.lucianazuza.agropopshop.controllers;

import java.util.List;

import org.dom4j.IllegalAddException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucianazuza.agropopshop.model.Cliente;
import br.com.lucianazuza.agropopshop.model.Produto;
import br.com.lucianazuza.agropopshop.repositories.ClienteRepository;
import br.com.lucianazuza.agropopshop.repositories.ProdutoRepository;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepo;
	@Autowired
	ProdutoRepository produtoRepo;
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes()
	{
		List<Cliente> lista = clienteRepo.findAll();
		ModelAndView mod = new ModelAndView("listarClientes");
		mod.addObject("clientes", lista);
		return mod;
	}
	
	@GetMapping("/adicionarCliente")
	public ModelAndView pageAdicionarCliente() {
		ModelAndView mod = new ModelAndView("adicionarCliente");
		mod.addObject(new Cliente());
		return mod;
	}
	
	@PostMapping("/adicionarCliente")
	public String adicionarCliente(Cliente c) {
		this.clienteRepo.save(c);
		return "redirect:/listarClientes";
	}
	
	@GetMapping("/editarCliente/{id}")
	public ModelAndView pageEditarCliente(@PathVariable("id") long id) {
		Cliente cliente = clienteRepo.findById(id).orElseThrow(
				()-> new IllegalAddException("id não existe"));
		ModelAndView mod = new ModelAndView("editarCliente");
		mod.addObject(cliente);
		return mod;
	}
	
	@PostMapping("/editarCliente/{id}")
	public ModelAndView editarCliente(@PathVariable("id") long id, Cliente cliente){
		this.clienteRepo.save(cliente);
		return new ModelAndView("redirect:/listarClientes");
	}
	
	@GetMapping("/removerCliente/{id}")
	public ModelAndView removerCliente(@PathVariable("id") long id) {
		Cliente a = clienteRepo.findById(id).orElseThrow(
				()-> new IllegalAddException("id não existe"));
		clienteRepo.delete(a);
		return new ModelAndView("redirect:/listarClientes");
	}
	
	/*--------------------------------------------------------------------*/
	
	@GetMapping("/listarProdutos")
	public ModelAndView listarProdutos()
	{
		List<Produto> lista = produtoRepo.findAll();
		ModelAndView mod = new ModelAndView("listarProdutos");
		mod.addObject("produtos", lista);
		return mod;
	}
	
	@GetMapping("/adicionarProduto")
	public ModelAndView pageAdicionarProduto() {
		ModelAndView mod = new ModelAndView("adicionarProduto");
		mod.addObject(new Produto());
		return mod;
	}
	
	@PostMapping("/adicionarProduto")
	public String adicionarProduto(Produto p) {
		this.produtoRepo.save(p);
		return "redirect:/listarProdutos";
	}
	
	@GetMapping("/editarProduto/{id}")
	public ModelAndView pageEditarProduto(@PathVariable("id") long id) {
		Produto produto = produtoRepo.findById(id).orElseThrow(
				()-> new IllegalAddException("id não existe"));
		ModelAndView mod = new ModelAndView("editarProduto");
		mod.addObject(produto);
		return mod;
	}
	
	@PostMapping("/editarProduto/{id}")
	public ModelAndView editarProduto(@PathVariable("id") long id, Produto produto){
		this.produtoRepo.save(produto);
		return new ModelAndView("redirect:/listarProdutos");
	}
	
	@GetMapping("/removerProduto/{id}")
	public ModelAndView removerProduto(@PathVariable("id") long id) {
		Produto a = produtoRepo.findById(id).orElseThrow(
				()-> new IllegalAddException("id não existe"));
		produtoRepo.delete(a);
		return new ModelAndView("redirect:/listarProdutos");
	}
	
}
