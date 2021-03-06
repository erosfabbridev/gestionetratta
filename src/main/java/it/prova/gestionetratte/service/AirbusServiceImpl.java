package it.prova.gestionetratte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.repository.airbus.AirbusRepository;

@Service
public class AirbusServiceImpl implements AirbusService {

	@Autowired
	private AirbusRepository airbusRepository;

	@Transactional
	@Override
	public List<Airbus> listAll() {

		return (List<Airbus>) airbusRepository.findAll();
	}

	@Transactional
	@Override
	public Airbus caricaSingoloElemento(Long id) {

		return airbusRepository.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public Airbus caricaSingoloElementoEager(Long id) {

		return airbusRepository.findSingleAirbusEager(id);
	}

	@Transactional
	@Override
	public Airbus aggiorna(Airbus input) {

		return airbusRepository.save(input);
	}

	@Transactional
	@Override
	public Airbus inserisci(Airbus input) {

		return airbusRepository.save(input);
	}

	@Transactional
	@Override
	public void rimuovi(Airbus input) {
		airbusRepository.delete(input);
	}

	@Transactional
	@Override
	public List<Airbus> findByExample(Airbus airbus) {
		
		return airbusRepository.trovaPerExample(airbus);
	}

	@Transactional
	@Override
	public List<Airbus> listAllEager() {
		
		return airbusRepository.findAllEager();
	}
	
	@Transactional
	@Override
	public List<Airbus> listConSovrapposizione(){
		return airbusRepository.findAllConSovrapposizione();
	}

	@Override
	public List<Airbus> listSenzaSovrapposizione() {
		
		return airbusRepository.findAllSenzaSovrapposizione();
	}
	
	

}
