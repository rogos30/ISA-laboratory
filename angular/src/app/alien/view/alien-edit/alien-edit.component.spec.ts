import {ComponentFixture, TestBed} from '@angular/core/testing';
import {AlienEditComponent} from './alien-edit.component';

describe('AlienEditComponent', ()=> {
  let component: AlienEditComponent;
  let fixture: ComponentFixture<AlienEditComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AlienEditComponent]
    });
    fixture = TestBed.createComponent(AlienEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
