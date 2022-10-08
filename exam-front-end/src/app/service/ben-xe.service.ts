import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenXe} from '../model/ben-xe';
import {DiemDen} from '../model/diem-den';
import {DiemDi} from '../model/diem-di';
import {environment} from '../../environments/environment';
const API_URL = `${environment.API_URl}`;
@Injectable({
  providedIn: 'root'
})
export class BenXeService {
  // private URL_BEN_XE = 'http://localhost:3000/ben-xe';
  // private URL_DIEM_DEN = 'http://localhost:3000/diem-den';
  // private URL_DIEM_DI = 'http://localhost:3000/diem-di';
  private URL_CONNECT = 'http://localhost:8080';


  constructor(private http: HttpClient) {
  }

  getAllBenXe(): Observable<BenXe[]> {
    return this.http.get<BenXe[]>(this.URL_CONNECT + '/ben-xe');
  }

  getAllDiemDen(): Observable<DiemDen[]> {
    return this.http.get<DiemDen[]>(this.URL_CONNECT + '/diem-den');
  }

  getAllDiemDi(): Observable<DiemDi[]> {
    return this.http.get<DiemDi[]>(this.URL_CONNECT + '/diem-di');
  }

  findById(id: number): Observable<BenXe> {
    return this.http.get<BenXe>(this.URL_CONNECT + '/findId/' + id);
  }

  editBenXe(id: number, benXe): Observable<BenXe> {
    return this.http.patch<BenXe>(this.URL_CONNECT + '/update' + id, benXe);
  }

  deleteBenXe(id: number): Observable<BenXe> {
    return this.http.delete<BenXe>(this.URL_CONNECT + '/delete' + id);
  }

  save(benXe: BenXe): Observable<BenXe> {
   return  this.http.post<BenXe>(this.URL_CONNECT + '/create', benXe);
  }

  searchByName(name: string,page: number): Observable<BenXe[]> {
    if(name==null) {
      name =""
    }
    return this.http.get<BenXe[]>(this.URL_CONNECT + '/ben-xe?name=' + name + '&page='+page);
  }
}
