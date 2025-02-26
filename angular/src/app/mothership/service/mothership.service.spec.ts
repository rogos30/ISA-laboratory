import {TestBed} from '@angular/core/testing';
import {MothershipService} from './mothership.service';

describe('MothershipService', ()=> {
  let service: MothershipService;
  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MothershipService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

