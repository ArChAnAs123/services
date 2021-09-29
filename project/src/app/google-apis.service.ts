import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient, HttpHeaders, HttpBackend } from '@angular/common/http';
import { book } from './book';
@Injectable({
  providedIn: 'root'
})
export class GoogleApisService {

  private baseUrl = 'http://localhost:8081/bookservice/';

  constructor(private httpClient:HttpClient,handler: HttpBackend ) {
    this.httpClient = new HttpClient(handler);
  }

  getAllBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=bestsellerh&maxResults=10`)
  }

  getDramaBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=drama&maxResults=5`)
  }
  getFictionBook() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=fiction&maxResults=5`)
  }
  getScienceBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=science&maxResults=5`)
  }
  getThrillerBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=thriller&maxResults=5`)
  }
  getArtBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=art&maxResults=5`)
  }
  getComedyBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=comedy&maxResults=5`)
  }
  getPhilosophyBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=philosophy&maxResults=5`)
  }

  getHorrorBooks() :Observable<any>
   {
    
    return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=subject:horror&maxResults=5`)
  }
//get details of books
getDetails(book) :Observable<any>
{
  console.log("in servuce");
  console.log(book.title);
  return this.httpClient.get<Array<any>>(`https://www.googleapis.com/books/v1/volumes?q=inAuthor=${book.title}&inTitle=${book.title}`)
}
  
  
}
