package zty.practise.algo.leetcode600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本质上是一颗多叉树
 * 
 * 需要根据id找到员工
 * 可以建立map映射id和员工 增加查询效率
 * 
 * 递归
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode690 {

	Map<Integer, Employee> map;
	int sum = 0;
	public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee employee : employees) {
        	map.put(employee.id, employee);
        }
        
        find(id);
        return sum;
    }
	
	private void find(int id) {
		Employee emp = map.get(id);
		sum += emp.importance;
		List<Integer> empIds = emp.subordinates;
		if(empIds == null || empIds.size() == 0) {
			return;
		}
		
		for(int empId : empIds) {
			find(empId);
		}
	}
	
	static class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	}

}
