<?php
require_once 'Film.php';
session_start();

// Initialize the data array if it doesn't exist
if (!isset($_SESSION['datafilm'])) {
    $_SESSION['datafilm'] = [];
}

$message = "";
$searchResult = null;

// Handle Form Submissions (Equivalent to the CLI command loop)
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $action = $_POST['action'] ?? '';
    $id = $_POST['id'] ?? '';

    if ($action === 'INPUT') {
        $film = new Film($id, $_POST['nama'], $_POST['genre'], (int)$_POST['harga'], (int)$_POST['jual']);
        $_SESSION['datafilm'][] = $film;
        $message = "FILM BERHASIL DIINPUT!";
    } 
    elseif ($action === 'UPDATE') {
        $updated = false;
        foreach ($_SESSION['datafilm'] as $key => $film) {
            if ($film->getId() === $id) {
                $_SESSION['datafilm'][$key] = new Film($id, $_POST['nama'], $_POST['genre'], (int)$_POST['harga'], (int)$_POST['jual']);
                $updated = true;
                break;
            }
        }
        $message = $updated ? "DATA FILM BERHASIL DIUPDATE!" : "DATA FILM GAGAL DIUPDATE!";
    } 
    elseif ($action === 'DELETE') {
        $deleted = false;
        foreach ($_SESSION['datafilm'] as $key => $film) {
            if ($film->getId() === $id) {
                unset($_SESSION['datafilm'][$key]);
                $_SESSION['datafilm'] = array_values($_SESSION['datafilm']); // Reindex array
                $deleted = true;
                break;
            }
        }
        $message = $deleted ? "FILM YANG DIPILIH BERHASIL DIHAPUS!" : "FILM YANG DIPILIH GAGAL DIHAPUS!";
    } 
    elseif ($action === 'SEARCH') {
        foreach ($_SESSION['datafilm'] as $film) {
            if ($film->getId() === $id) {
                $searchResult = $film;
                break;
            }
        }
        if (!$searchResult) {
            $message = "ID FILM TIDAK COCOK DENGAN FILM MANAPUN!";
        }
    }
}
?>

<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <title>Bioskop Manager</title>
    <style>
        body { font-family: monospace; background: #f4f4f4; padding: 20px; }
        .container { max-width: 900px; margin: auto; background: white; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; border-bottom: 2px dashed #000; padding-bottom: 10px; }
        .form-group { margin-bottom: 15px; background: #eef; padding: 10px; border-radius: 5px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #000; padding: 8px; text-align: left; }
        th { background-color: #ddd; }
        .message { color: green; font-weight: bold; margin-bottom: 15px; }
    </style>
</head>
<body>

<div class="container">
    <h2>==============================================<br>
        || SELAMAT DATANG DI BIOSKOP MANAGER! ||<br>
        ==============================================</h2>

    <?php if ($message): ?>
        <div class="message"><?php echo $message; ?></div>
    <?php endif; ?>

    <!-- Control Panel -->
    <div style="display: flex; gap: 20px;">
        <!-- Input & Update Form -->
        <div class="form-group" style="flex: 1;">
            <h3>Input / Update Film</h3>
            <form method="POST">
                ID: <input type="text" name="id" required><br><br>
                Nama: <input type="text" name="nama" required><br><br>
                Genre: <input type="text" name="genre" required><br><br>
                Harga: <input type="number" name="harga" required><br><br>
                Terjual: <input type="number" name="jual" required><br><br>
                <button type="submit" name="action" value="INPUT">INPUT</button>
                <button type="submit" name="action" value="UPDATE">UPDATE</button>
            </form>
        </div>

        <!-- Search & Delete Form -->
        <div class="form-group" style="flex: 1;">
            <h3>Search / Delete Film</h3>
            <form method="POST">
                ID Film: <input type="text" name="id" required><br><br>
                <button type="submit" name="action" value="SEARCH">SEARCH</button>
                <button type="submit" name="action" value="DELETE" onclick="return confirm('Yakin hapus film ini?')">DELETE</button>
            </form>

            <?php if ($searchResult): ?>
                <div style="margin-top: 15px; background: #dfd; padding: 10px;">
                    <strong>Hasil Pencarian:</strong><br>
                    ID: <?php echo $searchResult->getId(); ?><br>
                    Judul: <?php echo $searchResult->getNama(); ?><br>
                    Genre: <?php echo $searchResult->getGenre(); ?><br>
                    Harga: Rp <?php echo $searchResult->getHarga(); ?><br>
                    Terjual: <?php echo $searchResult->getJual(); ?>
                </div>
            <?php endif; ?>
        </div>
    </div>

    <!-- Data Table (Equivalent to SHOW format) -->
    <h3>Daftar Film (SHOW)</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>JUDUL FILM</th>
                <th>GENRE</th>
                <th>HARGA TIKET</th>
                <th>TERJUAL</th>
            </tr>
        </thead>
        <tbody>
            <?php if (empty($_SESSION['datafilm'])): ?>
                <tr><td colspan="5" style="text-align:center;">Belum ada film diinput</td></tr>
            <?php else: ?>
                <?php foreach ($_SESSION['datafilm'] as $film): ?>
                    <tr>
                        <td><?php echo htmlspecialchars($film->getId()); ?></td>
                        <td><?php echo htmlspecialchars($film->getNama()); ?></td>
                        <td><?php echo htmlspecialchars($film->getGenre()); ?></td>
                        <td><?php echo htmlspecialchars($film->getHarga()); ?></td>
                        <td><?php echo htmlspecialchars($film->getJual()); ?></td>
                    </tr>
                <?php endforeach; ?>
            <?php endif; ?>
        </tbody>
    </table>
</div>

</body>
</html>