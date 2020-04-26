package guru.springframework.employee.client.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer empId;
    @Column(nullable = false)
    private String empName;
    @Column(nullable = false)
    private BigDecimal salary;
    @Column()
    private String address;

    public Integer getEmpId() {
        return this.empId;
    }

    public String getEmpName() {
        return this.empName;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getAddress() {
        return this.address;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Employee)) return false;
        final Employee other = (Employee) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$empId = this.getEmpId();
        final Object other$empId = other.getEmpId();
        if (this$empId == null ? other$empId != null : !this$empId.equals(other$empId)) return false;
        final Object this$empName = this.getEmpName();
        final Object other$empName = other.getEmpName();
        if (this$empName == null ? other$empName != null : !this$empName.equals(other$empName)) return false;
        final Object this$salary = this.getSalary();
        final Object other$salary = other.getSalary();
        if (this$salary == null ? other$salary != null : !this$salary.equals(other$salary)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Employee;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $empId = this.getEmpId();
        result = result * PRIME + ($empId == null ? 43 : $empId.hashCode());
        final Object $empName = this.getEmpName();
        result = result * PRIME + ($empName == null ? 43 : $empName.hashCode());
        final Object $salary = this.getSalary();
        result = result * PRIME + ($salary == null ? 43 : $salary.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        return result;
    }

    public String toString() {
        return "Employee(empId=" + this.getEmpId() + ",empName=" + this.getEmpName() + ",salary=" + this.getSalary() + ",address=" + this.getAddress() + ")";
    }
}
