import {ComponentFixture, TestBed} from '@angular/core/testing';
import {MothershipViewComponent} from './mothership-view.component';

describe('AlienViewComponent', ()=> {
  let component: MothershipViewComponent;
  let fixture: ComponentFixture<MothershipViewComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MothershipViewComponent]
    });
    fixture = TestBed.createComponent(MothershipViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
