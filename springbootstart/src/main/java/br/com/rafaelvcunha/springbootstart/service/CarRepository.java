package br.com.rafaelvcunha.springbootstart.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rafaelvcunha.springbootstart.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
