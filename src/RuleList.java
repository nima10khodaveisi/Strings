import java.util.*;

public class RuleList implements Observer {
	//IN THIS CLASS, YOU NEED TO DEFINE THE APPROPRIATE FIELD(S)
	/**

	 this is rules

	 */
	private List<String> rules ;
	/**
	 * Constructs a new Taboo using the given rules
	 * @param rules rules for new Taboo
	 */
	public RuleList(List<String> rules) {
		this.rules = rules ;
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<String> noFollow(String elem) {
		Set<String> ret = new HashSet<>() ;
		for(int i = 0 ; i < rules.size() ; ++i) {
			if(i != rules.size() - 1 && rules.get(i).equals(elem))
				ret.add(rules.get(i + 1)) ;
		}
		if(ret.isEmpty())
			return Collections.emptySet() ;
		return ret ;
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules
	 * @param list collection to reduce
	 */

	private List<String> recursive(List<String> list) {
		List<String> ret = new ArrayList<>(list);
		for(int i = 0 ; i < list.size() - 1 ; ++i) {
			String str = list.get(i) ;
			Set<String> bads = noFollow(str) ;
			if(bads.contains(list.get(i + 1))) {
				List<String> cur = new ArrayList<>(list) ;
				cur.remove(i + 1) ;
				cur = recursive(cur) ;
				if(ret.size() > cur.size())
					ret = cur ;
			}
		}
		return ret ;
	}

	public void reduce(List<String> list) {
		List<String> myList = recursive(list) ;
		list.clear();
		list.addAll(myList);
	}

	@Override
	public void update(Observable observable, Object o) {

	}
}
