//SPDX-License-Identifier: MIT
pragma solidity ^0.6;
contract Health_Record
{
struct Patient 
{
int patient_id;
string name;
string height;
string weight;
string disease;
string symptom1;
string symptom2;
}
Patient[] Patients;
function addPatient(int patient_id, string memory name, string
memory height, string memory weight, string memory disease, string
memory symptom1, string memory symptom2) public
{
    Patient memory patient =
Patient(patient_id,name,height,weight,disease,symptom1,symptom2);
Patients.push(patient);
}
function getPatient(int patient_id) public view returns(string
memory, string memory, string memory, string memory, string memory,
string memory)
{
for (uint i=0; i<Patients.length; i++)
{
Patient memory patient = Patients[i];
if(patient.patient_id==patient_id)
{
return(patient.name,patient.height,patient.weight,patient.disease,patient.symptom1,patient.symptom2);
}
}
return("Name not Found", "Height not Found", "Weight not Found", "Disease not Found", "Symptom1 not Found", "Symptom2 not Found");
}
}

