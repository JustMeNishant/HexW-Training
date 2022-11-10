import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/model/book.model';
import { LibraryService } from 'src/app/services/library.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  bookArr:Book[];
  constructor(private libraryService:LibraryService,private route:Router) { }

  ngOnInit(): void {
    this.libraryService.getAllBooks().subscribe(data=>{
      this.bookArr=data;
    });
  }

  onLibrarySubmit(libraryForm:NgForm){
    console.log(libraryForm.value.search);
    this.bookArr=this.bookArr.filter(b=>b.name == libraryForm.value.search );
    //this.slotArr = this.slotArr.filter(s=>s.doctor.id == patientForm.value.doctor);
  }
  gotoAddBook(){
    this.route.navigateByUrl("/insert-book");
  }
}
