package com.codearena.problems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "problems")
public class Problem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false,unique = true,length = 1000)
private String title;

@Column(columnDefinition = "TEXT")
private String description;

@Column(columnDefinition = "TEXT")
private String inputformat;

@Column(columnDefinition = "TEXT")
private String outputformat;

@Column(name = "difficulty")
private String  difficulty;

@Column(columnDefinition = "TEXT")
private String constraints;

@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "problem_tag",joinColumns =@JoinColumn(name = "problem_id"))
@Column(name = "tag")
private List<String> tags;


@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "problem_company",joinColumns = @JoinColumn(name = "problem_id"))
private List<String> company;

@Column(updatable = false)
private String author="Admin";

@Temporal(TemporalType.DATE)
private Date createdat;

@OneToMany(mappedBy = "problem" ,cascade = CascadeType.ALL,orphanRemoval = true)
private List<TestCase> testCases;
}
