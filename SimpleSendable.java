public class SimpleSendable<T> implements Sendable<T>{
	private String from, to;
	private T content;

	public SimpleSendable(String from, String to, T content){
		this.from = from;
		this.to = to;
		this.content = content;
	}

	@Override
	public String getFrom(){
		return from;
	}
	
	@Override
	public String getTo(){
		return to;
	}

	@Override
	public T getContent(){
		return content;
	}
}