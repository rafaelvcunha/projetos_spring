package br.com.rafaelvcunha.server.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.rafaelvcunha.server.model.Report;

@RepositoryRestResource(collectionResourceRel = "report", path = "reports")

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

}
