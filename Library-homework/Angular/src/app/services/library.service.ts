import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../model/book.model';

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  constructor(private http:HttpClient) { }

  getAllBooks():Observable<Book[]> {
    return this.http.get<Book[]>("http://localhost:9155/book/get/all");
  }

  insertBook(book: Book):Observable<any> {
    return this.http.post<any>("http://localhost:9155/book/insert",book)
  }
}
