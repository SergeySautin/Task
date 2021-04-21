import java.util.*;
import java.util.function.*;

public class MailService<T> implements Consumer<Sendable<T>>{

	private Map<String, List<T>> messageMap = new HashMap<String, List<T>>(){

		public List<T> get(Object key){
			if(this.containsKey(key)){
				return super.get(key);
			}else{
				return Collections.emptyList();
			}
		}
	};

	public void accept(Sendable<T> sendable){
		List<T> ts = messageMap.get(sendable.getTo());
		if(ts.size() == 0){
			ts = new ArrayList<>();
		}

		ts.add(sendable.getContent());
		messageMap.put(sendable.getTo(), ts);
	}

	public Map<String, List<T>> getMailBox(){
		return messageMap;
	}
	
}