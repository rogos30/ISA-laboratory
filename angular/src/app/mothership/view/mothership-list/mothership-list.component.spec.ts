import {ComponentFixture, TestBed} from '@angular/core/testing';
import {MothershipListComponent} from './mothership-list.component';

describe('AlienListComponent', ()=> {
  let component: MothershipListComponent;
  let fixture: ComponentFixture<MothershipListComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MothershipListComponent]
    });
    fixture = TestBed.createComponent(MothershipListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
