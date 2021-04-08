import {Component, OnInit} from '@angular/core';
import {ErrorStateMatcher} from '@angular/material/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from '@angular/forms';
import {PackageServiceService} from '../../../services/package-service.service';
import {Router} from '@angular/router';

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}

@Component({
  selector: 'app-package-add',
  templateUrl: './package-add.component.html',
  styleUrls: ['./package-add.component.css']
})
export class PackageAddComponent implements OnInit {
  public formAddNewPackage: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1900, 0, 1);
  matcher = new MyErrorStateMatcher();
  public products;

  constructor(public formBuilder: FormBuilder,
              public packageService: PackageServiceService,
              public router: Router) {
  }

  ngOnInit(): void {
    this.packageService.getAllProduct().subscribe(data => {
      this.products = data;
      console.log(this.products);
    });

    this.formAddNewPackage = this.formBuilder.group({
      code: ['',[Validators.required, Validators.pattern(/^(LH-)\d{4}$/u)]],
      product: ['',[Validators.required]],
      quantity: ['',[Validators.required, Validators.pattern(/^[0-9]*$/u)]],
      ngayNhapHang: ['',[Validators.required]],
      ngaySanXuat: ['',[Validators.required]],
      ngayHetHan: ['',[Validators.required]]
    });
  }

  addNewPackage() {
    this.packageService.addNewPackage(this.formAddNewPackage.value).subscribe(data => {
      this.router.navigateByUrl('package-list');
    });
  }

  get code(){
    return this.formAddNewPackage.get('code');
  }

  get product(){
    return this.formAddNewPackage.get('product');
  }

  get quantity(){
    return this.formAddNewPackage.get('quantity');
  }

  get ngayNhapHang(){
    return this.formAddNewPackage.get('ngayNhapHang');
  }

  get ngaySanXuat(){
    return this.formAddNewPackage.get('ngaySanXuat');
  }

  get ngayHetHan(){
    return this.formAddNewPackage.get('ngayHetHan');
  }
}
