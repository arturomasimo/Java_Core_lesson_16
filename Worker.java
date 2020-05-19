package lession16;

public class  Worker{
	private String pib;
	private String posada;
	private int age;
	
	public Worker () {};
	
	public Worker(String pib, String posada) {
		super();
		this.pib = pib;
		this.posada = posada;
	}
	public Worker (String pib, String posada, int age) {
		super();
		this.pib = pib;
		this.posada = posada;
		this.age = age;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getPosada() {
		return posada;
	}

	public void setPosada(String posada) {
		this.posada = posada;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((pib == null) ? 0 : pib.hashCode());
		result = prime * result + ((posada == null) ? 0 : posada.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		if (age != other.age)
			return false;
		if (pib == null) {
			if (other.pib != null)
				return false;
		} else if (!pib.equals(other.pib))
			return false;
		if (posada == null) {
			if (other.posada != null)
				return false;
		} else if (!posada.equals(other.posada))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Worker [pib=" + pib + ", posada=" + posada + ", age=" + age + "]";
	} 

	
	
}
