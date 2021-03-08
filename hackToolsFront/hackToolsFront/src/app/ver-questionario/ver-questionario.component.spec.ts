import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerQuestionarioComponent } from './ver-questionario.component';

describe('VerQuestionarioComponent', () => {
  let component: VerQuestionarioComponent;
  let fixture: ComponentFixture<VerQuestionarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerQuestionarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerQuestionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
