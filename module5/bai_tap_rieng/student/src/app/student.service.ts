import { Injectable } from '@angular/core';
import {IStudent} from './student-info/model/IStudent';
import {studentRepository} from './student-info/model/StudentRepository';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor() { }

  addStudent(student: IStudent){
    studentRepository.push(student);
  }

  findStudent(id: number){
    // @ts-ignore
    return studentRepository.find(x => x.id === id);
  }
}
