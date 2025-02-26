import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Motherships} from '../model/motherships';
import {MothershipDetails} from '../model/mothership-details';
import {MothershipForm} from '../model/mothership-form';
import * as uuid from 'uuid';

@Injectable()
export class MothershipService {
  constructor(private http: HttpClient) {

  }

  getMotherships(): Observable<Motherships> {
    return this.http.get<Motherships>('http://localhost:8080/api/motherships');
  }

  getMothership(uuid: string): Observable<MothershipDetails> {
    return this.http.get<MothershipDetails>('http://localhost:8080/api/motherships/' + uuid);
  }

  deleteMothership(uuid: string): Observable<any> {
    return this.http.delete('http://localhost:8080/api/motherships/' + uuid);
  }

  updateMothership(uuid: string, request: MothershipForm): Observable<any> {
    return this.http.put('http://localhost:8080/api/motherships/' + uuid, request);
  }

  createMothership(request: MothershipForm): Observable<any> {
    return this.http.put('http://localhost:8080/api/motherships/' + uuid.v4(), request);
  }
}



