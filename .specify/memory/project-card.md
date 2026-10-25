# egovframe-hands-on-guide: project context

## Role and maintenance boundary

Step-by-step eGovFrame learning material and independent sample labs for IoC, logging, AOP, persistence, MVC, validation, and internationalization. Preserve the educational progression, lab-specific examples and configuration, and documented framework behavior.
This card reflects source inspection at adoption; it does not certify runtime behavior.

## Public entry points and evidence

- `README.md`: beginner-oriented environment setup and hands-on exercises, with Apache 2.0 sharing guidance.
- `lab6-1-ioc/pom.xml`: Java 8 source/target, Spring 5.3.37, eGovFrame RTE 4.3.0, JUnit 4, and EMMA plugin.
- `lab14-1-egovframe-sample/pom.xml`: Java 8 WAR example, JUnit Jupiter, Selenium, and Surefire selecting `**/*Test.java`.
- Other lab POMs are independent; there is no root POM or checked-in GitHub Actions workflow in the inspected tree.

## Build and verification entry points

Run Maven in the relevant lab, for example `mvn -f lab6-1-ioc/pom.xml test` or
`mvn -f lab14-1-egovframe-sample/pom.xml test`. These are entry points derived from the POMs,
not adoption results. Package only the changed lab when needed. A web exercise also needs its
matching servlet container and database configuration. Inspect actual Surefire discovery
before making claims about test coverage across labs.

## Environment and evidence limits

Preserve Java 8 compatibility declared by the sampled POMs. Older EMMA/build plugins and
database dependencies can constrain modern toolchains; public fork issue #2 requests a review,
not an already validated upgrade. Do not impose one unverified build command on every lab.
No application build, test suite, formatter, device test, or external service was run for this
workflow-only adoption. A Spec Kit CLI/status and isolated scaffold smoke validate the tooling
only. No CodeGraph index was present in the adoption workspace; targeted file listing and
exact text inspection supplied the evidence, without installing an indexer.

## Upstream and submission baseline

Upstream: [eGovFramework/egovframe-hands-on-guide](https://github.com/eGovFramework/egovframe-hands-on-guide). Fetch the actual upstream default branch
and record its exact SHA before preparing `upstream-submit`; do not infer the baseline from
fork work. Preserve an existing submission branch or open PR. Adoption changes are pushed
only to fork `work`; an absent `upstream-submit` is created from the fetched upstream SHA
without adoption commits, as a separate submission baseline.
The [constitution](constitution.md) is the policy source for domain cards, verification, and
work-only artifact isolation. Native OMP commands are in `.omp/commands/`; the bundled bug
workflow provides assess, fix, and test stages. No application fix or PR is part of
this adoption.
