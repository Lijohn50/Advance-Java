(function () {
  const menuBtn = document.getElementById("menu-btn");
  const mobileMenu = document.getElementById("mobile-menu");
  const yearEl = document.getElementById("year");
  const prefersReducedMotion = window.matchMedia("(prefers-reduced-motion: reduce)").matches;

  if (menuBtn && mobileMenu) {
    menuBtn.addEventListener("click", () => {
      const open = menuBtn.getAttribute("aria-expanded") === "true";
      menuBtn.setAttribute("aria-expanded", String(!open));
      mobileMenu.hidden = open;
    });
    mobileMenu.querySelectorAll("a").forEach((link) => {
      link.addEventListener("click", () => {
        menuBtn.setAttribute("aria-expanded", "false");
        mobileMenu.hidden = true;
      });
    });
  }

  if (yearEl) yearEl.textContent = String(new Date().getFullYear());

  // Scroll reveal
  const revealTargets = document.querySelectorAll(".reveal");
  if (prefersReducedMotion) {
    revealTargets.forEach((el) => el.classList.add("visible"));
  } else {
    const observer = new IntersectionObserver(
      (entries) => {
        entries.forEach((entry) => {
          if (entry.isIntersecting) {
            entry.target.classList.add("visible");
            observer.unobserve(entry.target);
          }
        });
      },
      { threshold: 0.08, rootMargin: "0px 0px -40px 0px" }
    );
    revealTargets.forEach((el) => observer.observe(el));
  }

  // Hero editor typewriter — cycles through status strings
  const caret = document.querySelector(".type-caret");
  const typedText = document.querySelector(".typed-text");
  if (caret && typedText && !prefersReducedMotion) {
    const strings = ["shipping...", "learning Spring Boot", "open to junior roles", "reading docs"];
    let stringIndex = 0;
    let charIndex = 0;
    let deleting = false;

    function tick() {
      const current = strings[stringIndex];
      if (!deleting) {
        charIndex++;
        typedText.textContent = current.slice(0, charIndex);
        if (charIndex === current.length) {
          deleting = true;
          setTimeout(tick, 1400);
          return;
        }
      } else {
        charIndex--;
        typedText.textContent = current.slice(0, charIndex);
        if (charIndex === 0) {
          deleting = false;
          stringIndex = (stringIndex + 1) % strings.length;
        }
      }
      setTimeout(tick, deleting ? 35 : 65);
    }
    setTimeout(tick, 900);
  } else if (typedText) {
    typedText.textContent = "shipping...";
  }
})();
