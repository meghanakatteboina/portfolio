package org.example.PortfolioApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Controller
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@GetMapping("/")
	public String home(Model model) {
		// Basic Info
		model.addAttribute("name", "Meghana Kateboina");
		model.addAttribute("contact", "+1(816)-634-7677 | meghanakateboina09@gmail.com");
		model.addAttribute("linkedin", "linkedin.com/in/meghana-kateboina");

		// Education
		Education education = new Education(
				"University of Central Missouri",
				"Master's in Computer Science",
				3.71,
				Arrays.asList(
						"Advanced Algorithms", "Cloud Computing", "Advanced Database Systems",
						"Compiler Design Construction", "Software Testing & Quality Assurance",
						"Advanced Operating Systems", "Machine Learning", "Information Assurance"
				),
				Arrays.asList(
						"Full Stack Development", "Cloud Foundations AWS",
						"Microsoft Certified: Azure Fundamentals",
						"REST API Design and Development",
						"Modern HTML, CSS, and JavaScript Certification"
				)
		);
		model.addAttribute("education", education);

		// Skills
		Skills skills = new Skills(
				Arrays.asList("Java", "Python", "JavaScript", "TypeScript", "HTML5", "CSS3"),
				Arrays.asList("Angular", "Spring Boot", "ReactJS", "Node.js", "Django", "Agile development", "Rest API"),
				Arrays.asList("PostgreSQL", "MySQL", "MongoDB", "DynamoDB", "Windows", "Linux"),
				Arrays.asList("Unit testing (JUnit5, Mockito, NUnit)", "Selenium WebDriver", "Cypress", "JUnit", "Postman"),
				Arrays.asList("AWS Services (EC2, Lambda, S3)", "Azure", "Docker", "SaaS Security"),
				Arrays.asList("Spring Security", "OAuth2", "Keycloak", "JWT", "Secure microservices architecture",
						"data encryption", "secure session management"),
				Arrays.asList("IntelliJ", "Visual Studio", "Maven", "Git", "Postman", "GitHub"),
				Arrays.asList("Distributed Software Development", "Object Oriented Programming", "System Design")
		);
		model.addAttribute("skills", skills);

		// Experience
		List<Experience> experiences = Arrays.asList(
				new Experience(
						"Web Mobilez, Remote, USA",
						"Software Development Engineer",
						"August 2024 - December 2024",
						Arrays.asList(
								"Enhanced user engagement by 30% by developing a Angular & TypeScript dashboard using AWS CloudFront, DynamoDB.",
								"Spearheaded the development of a Spring Boot backend, integrating seamlessly with REST APIs and API Gateway, enhancing data processing efficiency by 40%.",
								"Integrated PostgreSQL and optimized SQL queries, reducing data retrieval time by 25%.",
								"Championed Agile/Scrum methodologies, driving team collaboration and optimizing project delivery."
						)
				),
				new Experience(
						"Accenture, Hyderabad, India",
						"Software Engineer",
						"November 2020 - May 2023",
						Arrays.asList(
								"Built React-based front-end applications with TypeScript, breaking down wireframes into modular components for dynamic UIs.",
								"Optimized and managed REST API integrations for high-performance web applications.",
								"Enhanced Java API automation by integrating Maven, Gradle and AWS Lambda, reducing regression test times by 95%.",
								"Streamlined over 400 test scripts for both mobile and web platforms using Java, Selenium, Appium, and JUnit."
						)
				)
		);
		model.addAttribute("experiences", experiences);

		// Projects
		List<Project> projects = Arrays.asList(
				new Project(
						"CityXpressMart",
						"Interactive online shopping platform",
						Arrays.asList(
								"Developed using Python, ensuring smooth product browsing and order placement.",
								"Integrated MongoDB for efficient data management of customer interactions increasing data retrieval speed by 30%.",
								"Enhanced User Engagement by building interactive front-end components using HTML, CSS, JavaScript and Angular."
						)
				),
				new Project(
						"Health Guardian App",
						"Java Android app for personalized meal planning and nutrition tracking",
						Arrays.asList(
								"Designed for personalized meal planning, nutrition tracking & tailored suggestions for users.",
								"Achieved 97% code coverage for each file through 30+ JUnit test cases & rigorous testing.",
								"Enabled rich media uploads and robust image storage solutions by integrating Amazon S3."
						)
				)
		);
		model.addAttribute("projects", projects);

		// Leadership
		List<Leadership> leaderships = Arrays.asList(
				new Leadership(
						"Women in Cyber Security at UCM",
						"Vice-President",
						"August 2023 - December 2024"
				),
				new Leadership(
						"Blockonic2024, Kansas City, MO",
						"Participant",
						"October 2024"
				)
		);
		model.addAttribute("leaderships", leaderships);

		return "index";
	}
}

// Supporting classes
class Education {
	private String university;
	private String degree;
	private double gpa;
	private List<String> courses;
	private List<String> certifications;

	public Education(String university, String degree, double gpa, List<String> courses, List<String> certifications) {
		this.university = university;
		this.degree = degree;
		this.gpa = gpa;
		this.courses = courses;
		this.certifications = certifications;
	}

	// Getters
	public String getUniversity() { return university; }
	public String getDegree() { return degree; }
	public double getGpa() { return gpa; }
	public List<String> getCourses() { return courses; }
	public List<String> getCertifications() { return certifications; }
}

class Skills {
	private List<String> programmingTools;
	private List<String> frameworks;
	private List<String> databases;
	private List<String> testing;
	private List<String> cloudDevops;
	private List<String> security;
	private List<String> developmentTools;
	private List<String> miscellaneous;

	public Skills(List<String> programmingTools, List<String> frameworks, List<String> databases,
				  List<String> testing, List<String> cloudDevops, List<String> security,
				  List<String> developmentTools, List<String> miscellaneous) {
		this.programmingTools = programmingTools;
		this.frameworks = frameworks;
		this.databases = databases;
		this.testing = testing;
		this.cloudDevops = cloudDevops;
		this.security = security;
		this.developmentTools = developmentTools;
		this.miscellaneous = miscellaneous;
	}

	// Getters
	public List<String> getProgrammingTools() { return programmingTools; }
	public List<String> getFrameworks() { return frameworks; }
	public List<String> getDatabases() { return databases; }
	public List<String> getTesting() { return testing; }
	public List<String> getCloudDevops() { return cloudDevops; }
	public List<String> getSecurity() { return security; }
	public List<String> getDevelopmentTools() { return developmentTools; }
	public List<String> getMiscellaneous() { return miscellaneous; }
}

class Experience {
	private String company;
	private String position;
	private String duration;
	private List<String> achievements;

	public Experience(String company, String position, String duration, List<String> achievements) {
		this.company = company;
		this.position = position;
		this.duration = duration;
		this.achievements = achievements;
	}

	// Getters
	public String getCompany() { return company; }
	public String getPosition() { return position; }
	public String getDuration() { return duration; }
	public List<String> getAchievements() { return achievements; }
}

class Project {
	private String name;
	private String description;
	private List<String> features;

	public Project(String name, String description, List<String> features) {
		this.name = name;
		this.description = description;
		this.features = features;
	}

	// Getters
	public String getName() { return name; }
	public String getDescription() { return description; }
	public List<String> getFeatures() { return features; }
}

class Leadership {
	private String organization;
	private String position;
	private String duration;

	public Leadership(String organization, String position, String duration) {
		this.organization = organization;
		this.position = position;
		this.duration = duration;
	}

	// Getters
	public String getOrganization() { return organization; }
	public String getPosition() { return position; }
	public String getDuration() { return duration; }
}