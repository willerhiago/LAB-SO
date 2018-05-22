package comparacao;

public class Calculo {
	
	private long[] valores;
	private long media;
	private long desvioPadrao;
	private long qntElem;
	
	public void calculaMediaEDesvio(long[] valores) {
		this.valores = valores;
		this.qntElem = valores.length;
		double soma = 0;
		for(int i = 0; i < qntElem;i++){
			soma += (valores[i]/1000);
			
		}
		this.media =(long)(soma/qntElem);
		this.calculaDesvio();
	}
	
	private void calculaDesvio() {
		long somaVariancia = 0;
		long variacao;
		
		for(int i = 0; i < qntElem;i++){
			variacao = valores[i] - this.media;
			somaVariancia += (long)Math.pow(variacao,2);
			
		}
		this.desvioPadrao =  (long)Math.sqrt(somaVariancia/(qntElem - 1)); 
	}

	
	//--------------------------------Getters
	public long[] getValores() {
		return valores;
	}

	public long getMedia() {
		return media;
	}

	public long getDesvioPadrao() {
		return desvioPadrao;
	}

	public long getQntElem() {
		return qntElem;
	}
	
	
}
