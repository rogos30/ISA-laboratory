import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Aliens} from '../model/aliens';
import {AlienDetails} from '../model/alien-details';
import {AlienForm} from '../model/alien-form';
import * as uuid from 'uuid';

@Injectable()
export class AlienService {
  constructor(private http: HttpClient) {

  }

  getAliens(): Observable<Aliens> {
    return this.http.get<Aliens>('http://localhost:8080/api/aliens');
  }

  getAliensFromMothership(mothershipId: string): Observable<Aliens> {
    return this.http.get<Aliens>('http://localhost:8080/api/motherships/' + mothershipId + '/aliens');
  }

  getAlien(uuid: string): Observable<AlienDetails> {
    return this.http.get<AlienDetails>('http://localhost:8080/api/aliens/' + uuid);
  }

  deleteAlien(uuid: string): Observable<any> {
    return this.http.delete('http://localhost:8080/api/aliens/' + uuid);
  }

  updateAlien(uuid: string, request: AlienForm): Observable<any> {
    return this.http.put('http://localhost:8080/api/aliens/' + uuid, request);
  }

  createAlien(request: AlienForm): Observable<any> {
    return this.http.put('http://localhost:8080/api/aliens/' + uuid.v4(), request);
  }
}
