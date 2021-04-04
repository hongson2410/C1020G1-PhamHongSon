import {Component, Input, OnInit} from '@angular/core';
import {studentRepository} from '../student-info/model/StudentRepository';
import {IStudent} from '../student-info/model/IStudent';
import {faInfoCircle, faTrashAlt, faEdit} from '@fortawesome/free-solid-svg-icons';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  faInfoCircle = faInfoCircle;
  faTrashAlt = faTrashAlt;
  faEdit = faEdit;
  students = studentRepository;
  student: IStudent;
  closeResult: string;
  studentNameDelete: string;

  constructor(private modalService: NgbModal) {
  }

  ngOnInit(): void {
  }

  open(content, student) {
    this.studentNameDelete = student.name;
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
      if (result === 'yes') {
        this.deleteHero(student.id);
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

  deleteHero(id) {
    this.students = this.students.filter(x => x.id !== id);
  }
}
