package br.com.rafaelvcunha.tasklet;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

public class FileDeletingTasklet implements Tasklet, InitializingBean {

  private Resource directory;

  @Override
  public void afterPropertiesSet(){
	  
  } 

  @Override
  public RepeatStatus execute(StepContribution contribution,
               ChunkContext chunkContext) throws Exception {

	File dir = directory.getFile();

	File[] files = dir.listFiles();
	for (int i = 0; i < files.length; i++) {
	      if (!files[i].isDirectory()){ 
			  boolean deleted = files[i].delete();
			  if (!deleted) {
				throw new UnexpectedJobExecutionException(
		                       "Could not delete file " + files[i].getPath());
			  } else {
			        System.out.println(files[i].getPath() + " is deleted!");
			  }
	      }
	}
	return RepeatStatus.FINISHED;
  }

  public Resource getDirectory() {
	return directory;
  }

  public void setDirectory(Resource directory) {
	this.directory = directory;
  }

}