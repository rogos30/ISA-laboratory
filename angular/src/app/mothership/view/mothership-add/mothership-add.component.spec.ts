import {ComponentFixture, TestBed} from '@angular/core/testing';
import {MothershipAddComponent} from './mothership-add.component';

describe('AlienAddComponent', ()=> {
  let component: MothershipAddComponent;
  let fixture: ComponentFixture<MothershipAddComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MothershipAddComponent]
    });
    fixture = TestBed.createComponent(MothershipAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
