package br.com.rafaelvcunha.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.rafaelvcunha.server.model.Report;

@RepositoryRestResource(collectionResourceRel = "report", path = "reports")
public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

   
    /**
     * Método que retorna a linha fazendo a busca com o id passado como parâmetro.
     * 
     * @param id
     * @return Report do id passado como parâmetro.
     */   
    @Query("SELECT * FROM RAW_REPORT r where r.id = :id") 
    Report findLinhaById(@Param("id") Long id);
    
    /**
     * Método que retorna uma lista de staffName fazendo a busca pelo staffName passado como parâmetro e ordenando os 
     * pelo staffName.
     *  
     * @param staffName
     * @return lista de staffName
     */
    List<Report> findByStaffNameOrderByStaffName(@Param("staffName") String staffName);

	
}
