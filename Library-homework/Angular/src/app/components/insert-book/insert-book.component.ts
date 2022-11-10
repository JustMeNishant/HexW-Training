import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from 'src/app/model/book.model';
import { LibraryService } from 'src/app/services/library.service';

@Component({
  selector: 'app-insert-book',
  templateUrl: './insert-book.component.html',
  styleUrls: ['./insert-book.component.css']
})
export class InsertBookComponent implements OnInit {

  constructor(private libraryService:LibraryService,private router:Router) { }

  ngOnInit(): void {
  }
  onBookSubmit(bookForm:NgForm){
    let book:Book = {
      'name':bookForm.value.name,
      'genre':bookForm.value.genre,
      'status':true,
      'price':bookForm.value.price
    }
    this.libraryService.insertBook(book).subscribe();

  }

  goHome(){
    this.router.navigateByUrl("/");
  }

}
