package lab;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("employeeDAO")
public class EmployeeDAO extends EgovAbstractMapper {

  public void insertEmployee(CustomerVO vo) {
    insert("employee.insertEmployee", vo);
  }

  public int deleteAllEmployee(CustomerVO vo) {
    return delete("employee.deleteAllEmployee", vo);
  }

  public int updateEmployee(CustomerVO vo) {
    return update("employee.updateEmployee", vo);
  }

  public List<CustomerVO> selectEmployeeList(CustomerVO vo) {
    return selectList("employee.selectEmployeeList", vo);
  }

}
