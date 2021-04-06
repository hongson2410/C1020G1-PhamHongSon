import {Component, OnInit} from '@angular/core';
import {IStudent} from '../student-info/model/IStudent';
import {faEdit, faInfoCircle, faTrashAlt} from '@fortawesome/free-solid-svg-icons';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {StudentService} from '../student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  faInfoCircle = faInfoCircle;
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;

  students: IStudent[];

  closeResult: string;
  studentNameDelete: string;

  constructor(private modalService: NgbModal,
              private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.studentService.getAllStudent().subscribe(next => {this.students = next});
  }

  open(content, student) {
    this.studentNameDelete = student.name;
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      if (result === 'yes') {
        this.deleteStudent(student.id);
      }
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  deleteStudent(id) {
    this.studentService.deleteStudent(id).subscribe(
      () => {
        this.students = this.students.filter(
          t => t.id != id
        );
      });
  }
}
