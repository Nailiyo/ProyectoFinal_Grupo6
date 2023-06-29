package com.edu.unju.edm.PV2023;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalGrupo6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalGrupo6Application.class, args);	
	}
	/**@Autowired
	CuestionarioPregunta cuestionarioPregunta;
	@Autowired
	ICuestionarioPreguntaService cuestionarioPreguntaService;
	@Autowired
	CuestionarioRepository cuestionarioRepository;
	@Autowired
	PreguntaRepository preguntaRepository;
	**/
	@Override
	public void run (String... args) throws Exception{
		
		/**cuestionarioPregunta.setPuntaje(55);
		cuestionarioPregunta.setCuestionario(cuestionarioRepository.findById(4).orElseThrow());
		cuestionarioPregunta.setPregunta(preguntaRepository.findById(3).orElseThrow());
		cuestionarioPreguntaService.cargarCuestionarioPregunta(cuestionarioPregunta, 4);
		**/
		
	}
	
}
