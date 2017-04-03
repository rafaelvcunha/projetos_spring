package br.com.rafaelvcunha.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

public class FileMoveTasklet implements Tasklet, InitializingBean {
	
	private Resource directoryIn;
	private Resource directoryOut;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		
		
		return RepeatStatus.FINISHED;
	}

	public Resource getDirectoryIn() {
		return directoryIn;
	}

	public void setDirectoryIn(Resource directoryIn) {
		this.directoryIn = directoryIn;
	}

	public Resource getDirectoryOut() {
		return directoryOut;
	}

	public void setDirectoryOut(Resource directoryOut) {
		this.directoryOut = directoryOut;
	}

}
