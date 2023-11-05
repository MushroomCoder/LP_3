//Aryan Sirdesai
pragma solidity ^0.6.0;
contract student_management {
struct student {
int stud_id;
string name;
string department;
}
student[] students;
function add_stud(int stud_id, string memory name, string memory department ) public {
student memory stud = student(stud_id , name, department);
students.push(stud);
}
function getStudent(int stud_id) public view returns(string memory, string memory) {
for(uint i = 0; i<students.length; i++) {
student memory stud = students [i];
if(stud.stud_id == stud_id) {
return(stud.name, stud.department);
}
}
return("not found","not found");
}
}