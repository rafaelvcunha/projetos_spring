package br.com.rafaelvcunha.tasklet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

public class FileMoveTasklet implements Tasklet, InitializingBean {
	
	private Resource directoryIn;
	private Resource directoryOut;
	private SimpleDateFormat data = new SimpleDateFormat("yyyyMMdd_HHmmss");

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		
		
		// Arquivos que iremos copiar
		File origem = directoryIn.getFile();
		File destino = directoryOut.getFile();
		File novoNome = new File("src/main/resources/csv/input/old/report_"+ data.format(Calendar.getInstance().getTime()) +".csv");
		 
		// abrimos os streams para leitura/escrita
		FileInputStream fis = new FileInputStream(origem);
		FileOutputStream fos = new FileOutputStream(destino);
		 
		// Obtém os canais por onde lemos/escrevemos nos arquivos
		FileChannel inChannel = fis.getChannel();
		FileChannel outChannel = fos.getChannel();
		 
		// copia todos o conteúdo do canal de entrada para o canal de saída
		outChannel.transferFrom(inChannel, 0, inChannel.size());
		
		destino.renameTo(novoNome);
				
		fis.close();
		fos.close();
		
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
