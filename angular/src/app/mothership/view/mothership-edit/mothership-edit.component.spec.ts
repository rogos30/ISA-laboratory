import {ComponentFixture, TestBed} from '@angular/core/testing';
import {MothershipEditComponent} from './mothership-edit.component';

describe('AlienEditComponent', ()=> {
  let component: MothershipEditComponent;
  let fixture: ComponentFixture<MothershipEditComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MothershipEditComponent]
    });
    fixture = TestBed.createComponent(MothershipEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
